package directory;

import java.io.File;
import java.io.IOException;

public class DirectoryPaser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DirectoryPaser dirPaser =new DirectoryPaser();
		dirPaser.subDirList("./BIGFILE");
	}
	public void subDirList(String source){
		File dir = new File(source); 
		File[] fileList = dir.listFiles(); 
		try{
			for(int i = 0 ; i < fileList.length ; i++){
				File file = fileList[i]; 
				if(file.isFile()){
    // ������ �ִٸ� ���� �̸� ���
					System.out.println("\t ���� �̸� = " + file.getName());
				}else if(file.isDirectory()){
					System.out.println("���丮 �̸� = " + file.getName());
    // ������丮�� �����ϸ� ����� ������� �ٽ� Ž��
					subDirList(file.getCanonicalPath().toString()); 
				}
			}
		}catch(IOException e){
			
		}
	}

}
