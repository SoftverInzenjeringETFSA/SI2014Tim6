package ba.unsa.etf.si.app.RezervacijaZGTim6;

import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;
import org.apache.log4j.Logger;
import org.hibernate.Transaction;
import org.hibernate.Session;

import ba.unsa.etf.si.app.RezervacijaZGTim6.Forme.LoginScreen;

public class App {
	private static File f;
	private static FileChannel channel;
	private static FileLock lock;
	final static Logger logger = Logger.getLogger(App.class);
public static void main(String[] args)
{
	try {
		
		    f = new File("RingOnRequest.lock");
		    // Check if the lock exist
		    if (f.exists()) {
		    // if exist try to delete it
		    f.delete();
		  }
		  // Try to get the lock
		  channel = new RandomAccessFile(f, "rw").getChannel();
		  lock = channel.tryLock();
		  if(lock == null)
		  {
		    // File is lock by other application
		    channel.close();
		    throw new RuntimeException("Only 1 instance of MyApp can run.");
		  }
		  // Add shutdown hook to release lock when application shutdown
		  ShutdownHook shutdownHook = new ShutdownHook();
		  Runtime.getRuntime().addShutdownHook(shutdownHook);
		
		
		
		
		final Restoran ZmajevoGnijezdo = Restoran.getInstance();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try 
				{
					LoginScreen window = new LoginScreen(ZmajevoGnijezdo);
					window.getFrmPrijavaKorisnika().setVisible(true);
				} catch (Exception e) {
					logger.error("Greska!", e);
				}
			}
		});
	} 
	catch (Exception e)
	{
		// TODO Auto-generated catch block
		logger.error("Greska!", e);
	}
}

public static void unlockFile() {
	// release and delete file lock
	  try {
	    if(lock != null)
	    lock.release();
	    channel.close();
	    f.delete();
	  } catch(IOException e) {
		  logger.error("Greska!", e);
	  }
	}

static class ShutdownHook extends Thread {
	  public void run() {
	    unlockFile();
	  }
	}

}



