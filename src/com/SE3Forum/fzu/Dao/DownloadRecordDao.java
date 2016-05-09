package com.SE3Forum.fzu.Dao;

/**
 * Created by Feng on 5/4/16.
 */
public class DownloadRecordDao extends BaseDao {
    /*
    * 下载记录 只在用户进行下载的时候执行 插入操作.用户无法直接操作.
    * 用户可以执行的操作 只有查看功能 无法进行其它功能(这里只列出dao 层的操作,一些操作全部封装进 service)
    *   1. 查看自己的下载记录* 这里的全部功能都需要验证用户信息,用户只能查看自己的下载记录,不能查看其它人的下载记录
    *   2. 查找文件上传人
    *   3. 根据时间来查找文件*/
}
