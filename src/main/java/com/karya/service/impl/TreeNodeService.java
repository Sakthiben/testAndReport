package com.karya.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.karya.model.TreeNode001MB;
import com.karya.service.ITreeNodeService;

import com.karya.dao.ITreeNodeDAO;

@Service("TreeNodeService")
@Transactional

public class TreeNodeService implements ITreeNodeService {
	
	@Autowired
	private ITreeNodeDAO treeNodeDAO;
	
	private List<TreeNode001MB> dummytreeNodeList = new ArrayList<TreeNode001MB>();
	
	protected static Logger logger = Logger.getLogger("service");
	
	/*public TreeNodeService()
	{
		init();
	}*/
	public List<TreeNode001MB> getAll() {
		logger.debug("Retrieving all TreeNode");

		//return dummytreeNodeList;
		return treeNodeDAO.getAll();
	}
	
	public TreeNode001MB get( String id ) {
		logger.debug("Retrieving an existing TreeNode");
		
		return dummytreeNodeList.get( Integer.valueOf(id) );
		
	}

	public Boolean add(TreeNode001MB treeNode)
	{
		logger.debug("Adding a new user");
	
	try {
		// Assign a new id
		treeNodeDAO.add(treeNode);
		return true;
	} catch (Exception e) {
		return false;
	}
	}
	
	public Boolean delete( TreeNode001MB treeNode ) {
		logger.debug("Deleting an existing treeNode");
		
		try {
			// Retrieve id to delete
			Long id =  Long.valueOf( treeNode.getId().toString() );
			
			// Loop array
			for ( TreeNode001MB dummytreeNode: dummytreeNodeList) {
				if ( dummytreeNode.getId().compareTo(id) == 0 ) {
					dummytreeNodeList.remove(dummytreeNode); 
					break;
				}
			}
			
			return true;
		} catch (Exception e) {
			return false;
		}

	}
	
	public Boolean edit( TreeNode001MB treeNode ) {
		logger.debug("Editing an existing treeNode");
		
		try {
			// Retrieve id to edit
			/*Long id =  Long.valueOf( treeNode.getId().toString() );
			
			// Loop array
			for ( TreeNode dummyTreeNode: dummytreeNodeList) {
				if ( dummyTreeNode.getId().compareTo(id) == 0 ) {
					dummyTreeNode.setParentName( treeNode.getParentName());
					
					break;
				}
			}*/
			treeNodeDAO.edit(treeNode);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	
}










