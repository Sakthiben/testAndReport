package com.karya.dao;

import java.util.List;
import com.karya.model.TreeNode001MB;

public interface ITreeNodeDAO {
	
	List<TreeNode001MB> getAll();
	void add(TreeNode001MB treeNode);
	void delete(Long id);
	void edit(TreeNode001MB treeNode);

}
