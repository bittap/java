package google.drive;

/*
 * Copyright (c) 2013 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
import com.google.api.client.util.IOUtils;
import com.google.api.client.util.Maps;
import com.google.api.client.util.Throwables;
import com.google.api.client.util.store.AbstractDataStoreFactory;
import com.google.api.client.util.store.DataStore;
import com.google.api.client.util.store.FileDataStoreFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Logger;

/**
 * Thread-safe file implementation of a credential store.
 *
 * <p>
 * For security purposes, the file's permissions are set to be accessible only by the file's owner.
 * Note that Java 1.5 does not support manipulating file permissions, and must be done manually or
 * using the JNI.
 * </p>
 *
 * @since 1.16
 * @author Yaniv Inbar
 */
public class FileDataStoreFactory2 extends AbstractDataStoreFactory {

  private static final Logger LOGGER = Logger.getLogger(FileDataStoreFactory.class.getName());

  /** Directory to store data. */
  private final File dataDirectory;

  /**
   * @param dataDirectory data directory
   */
  public FileDataStoreFactory2(File dataDirectory) throws IOException {
    dataDirectory = dataDirectory.getAbsoluteFile();
    this.dataDirectory = dataDirectory;
    if (IOUtils.isSymbolicLink(dataDirectory)) {
        throw new IOException("unable to use a symbolic link: " + dataDirectory);
      }
      // create parent directory (if necessary)
      if (!dataDirectory.exists() && !dataDirectory.mkdirs()) {
        throw new IOException("unable to create directory: " + dataDirectory);
      }
    setPermissionsToOwnerOnly(dataDirectory);
  }

  /** Returns the data directory. */
  public final File getDataDirectory() {
    return dataDirectory;
  }

  /**
   * Attempts to set the given file's permissions such that it can only be read, written, and
   * executed by the file's owner.
   *
   * @param file the file's permissions to modify
   * @throws IOException
   */
  static void setPermissionsToOwnerOnly(File file) throws IOException {
    // Disable access by other users if O/S allows it and set file permissions to readable and
    // writable by user. Use reflection since JDK 1.5 will not have these methods
    try {
      Method setReadable = File.class.getMethod("setReadable", boolean.class, boolean.class);
      Method setWritable = File.class.getMethod("setWritable", boolean.class, boolean.class);
      Method setExecutable = File.class.getMethod("setExecutable", boolean.class, boolean.class);
      if (!(Boolean) setReadable.invoke(file, false, false)
          || !(Boolean) setWritable.invoke(file, false, false)
          || !(Boolean) setExecutable.invoke(file, false, false)) {
        LOGGER.warning("unable to change permissions for everybody: " + file);
      }
      if (!(Boolean) setReadable.invoke(file, true, true)
          || !(Boolean) setWritable.invoke(file, true, true)
          || !(Boolean) setExecutable.invoke(file, true, true)) {
        LOGGER.warning("unable to change permissions for owner: " + file);
      }
    } catch (InvocationTargetException exception) {
      Throwable cause = exception.getCause();
      Throwables.propagateIfPossible(cause, IOException.class);
      // shouldn't reach this point, but just in case...
      throw new RuntimeException(cause);
    } catch (NoSuchMethodException exception) {
      LOGGER.warning("Unable to set permissions for " + file
          + ", likely because you are running a version of Java prior to 1.6");
    } catch (SecurityException exception) {
      // ignored
    } catch (IllegalAccessException exception) {
      // ignored
    } catch (IllegalArgumentException exception) {
      // ignored
    }
  }

	@Override
	protected <V extends Serializable> DataStore<V> createDataStore(String id) throws IOException {
		return null;
	}
}

