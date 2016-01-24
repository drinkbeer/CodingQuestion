/*
File System. Explain the data structures and algorithms that you would use to design an in-memory file system. Illustrate with an example in code where possible.

What contains in FS? File, directory

File:
    attribute: id, name, partent directory name, file type(doc, xls, txt...), file status(read, write, read only, hidden)
    action: read content, set status, move to directory

Directory:
    attribute: id, name, parent directory name, # of files, status?(read, write, read only, hidden)
    action: iterate files, move out, put into
*/

public enum Status{
    READ, WRITE, READ_ONLY, HIDDEN
}

public enum FileType{
    DOC, DOCX, XLS, XLSX, TXT, PPT, PPTX
}

public class Entry{
    protected String name;
    protected String parentDirectory;
    protected Status status;
    protected Date createDate;
    protected Date modifyDate;
    protected Date lastAccessDate;

    public Entry(){...} //constructor, name, default status, create time/modify time/last access time are all current time

    public void setName(String name){...}
    public String getName(){...}
    public String getParentDirectory(){...}
    public Status getStatus(){...}
    public void setRead(){...}
    public void setWrite(){...}
    public void setReadOnly(){...}
    public void setHidden(){...}
    public void setCreateTime(){...}    //set to curr time
    public void setModifyTime(){...}    //set modify time
    public void setLastAccessDate(){...}    //set last access time

}

public class File extends Entry{
    private int id;
    private FileType type;

    public File(){...}  //set id here
    public int getId(){...}
    public FileType getType(){...}
    public void setType(FileType type){...}
    public void readContent(){...}  // read all content of this file
    public void writeContent(String str){...}
    public void deleteContent(String str){...}
    public void modifyContent(String str){...}
    public boolean searchContent(String str){...}
    public boolean MoveToDirectory(){...}
    public boolean isFile(){...}
}

public class Directory extends Entry{
    private int id;
    private int numOfFiles;
    private List<Entry> files;  //there may be both File and Directory in curr directory

    public Directory(){...} // constructor, set id when constructed
    public int getId(){...}
    public int getNumOfFiles(){...}
    public int getNumOfDirectories(){...}
    public void iterateFiles(){...}
    public boolean putInto(File file){...}  //put file into curr directory
    public boolean deleteFile(File file){...}
    public boolean deleteFileDirectory(Directory dir){...}
    public boolean moveTo(Directory dir){...}
    public File getFile(int id){...} //search for a file
    public Directory getDirectory(int id){...} // search for a file
    public List<Entry> getAll(){...}
    public boolean isDirectory(){...}

}