package com.karya.service;

import java.util.List;

import com.karya.model.TreeNode001MB;

public interface ITreeNodeService {
	
	public List<TreeNode001MB> getAll();
	
	public TreeNode001MB get(String id);
	
	
	public Boolean add(TreeNode001MB treeNode);
	
	public Boolean delete(TreeNode001MB treeNode);
	
	public Boolean edit(TreeNode001MB treeNode);
	


}
