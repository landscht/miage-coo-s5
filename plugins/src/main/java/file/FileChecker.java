package file;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import filters.FileClassFilter;
import filters.PluginFilter;
import listeners.FileListener;

/**
 * 
 * @author Gabriel, Tony
 *
 */

public class FileChecker implements ActionListener{
	
	private File file;
	private ArrayList<String> knownFiles;
	private ArrayList<FileListener> fileListeners;
	private FilenameFilter filter;
	
	/**
	 * 
	 * @param name the path of the directory
	 */
	
	public FileChecker(String name,FilenameFilter filter){
		knownFiles = new ArrayList<>();
		fileListeners = new ArrayList<>();
		file = new File(name);
		this.filter = filter;
	}
	
	/**
	 * 
	 * @param l the listener to add
	 */
	
	public synchronized void addFileListener(FileListener l){
		if(fileListeners.contains(l)){ return; }
		fileListeners.add(l);
	}
	
	/**
	 * 
	 * @param l the listener to remove
	 */
	
	public synchronized void removeFileListener(FileListener l){
		fileListeners.remove(l);
	}
	
	/**
	 * 
	 * @return the list of listeners
	 */
	
	public List<FileListener> getListeners(){
		return fileListeners;
	}
	
	/**
	 * 
	 * @param name the file to add to the listeners
	 */
	
	public void fireFileAdded(String name){
		ArrayList<FileListener> fl=(ArrayList<FileListener>)fileListeners.clone();
		if(fl.size()==0){ return ; }
		FileEvent event = new FileEvent(name);
		for(FileListener listener : fileListeners){
			listener.fileAdded(event);
		}
	}
	
	/**
	 * 
	 * @param name the file to remove to the listeners
	 */
	
	public void fireFileRemoved(String name){
		ArrayList<FileListener> fl=(ArrayList<FileListener>)fileListeners.clone();
		if(fl.size()==0){ return ; }
		FileEvent event = new FileEvent(name);
		for(FileListener listener : fileListeners){
			listener.fileRemoved(event);
		}
	}
	
	/**
	 * checks if there is a change in the directory
	 */
	
	public void check() {
		ArrayList<String> unknown=(ArrayList<String>)knownFiles.clone();
		String[] tab = file.list(filter);
		for(String s : tab) {
			if(!knownFiles.contains(s)) {
				fireFileAdded(s);
				knownFiles.add(s); 
			}else{
				unknown.remove(s);
			}
		}
		for(String s : unknown) {
			knownFiles.remove(s);
			fireFileRemoved(s);
		}
	}
	
	/**
	 * performs the check action
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		check();
	}
	
	
	

}
