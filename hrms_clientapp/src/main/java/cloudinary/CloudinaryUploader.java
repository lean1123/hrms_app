package cloudinary;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import entity.Employee;
import gui.main.Application;

public class CloudinaryUploader extends Thread {
	static String CLOUDINARY_URL = "cloudinary://577653484354958:R8mLoMgAd0_gedm8SRT4-vfSKoA@dohpvtyop";
    private String urlPhoto;
    private String filePath;
    private int idEm;
    
    
    
    public  String getUrlPhoto() {
		return urlPhoto;
	}

	public  void setUrlPhoto(String urlPhoto) {
		this.urlPhoto = urlPhoto;
	}

	public CloudinaryUploader(int idEm, String filePath) {
        this.filePath = filePath;
        this.idEm = idEm;
    }
    
    @Override
    public void run() {
        try {
			this.urlPhoto = uploadImageToCloudinary(filePath);
			Employee employee = Application.employeeDao.findById(idEm);
			employee.setAvatar(this.urlPhoto);
			Application.employeeDao.update(employee);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    public String uploadImageToCloudinary(String pathFile) throws IOException {
    	Path path = Paths.get(filePath);
		String fileName = path.getFileName().toString();
		String fileNameWithoutExtension = fileName.substring(0, fileName.lastIndexOf('.'));
    	Cloudinary cloudinary = new Cloudinary(CLOUDINARY_URL);
        cloudinary.config.secure = true;
        File file = new File(pathFile);
        String folderName = "image-profile"; // Thay "image-profile" bằng tên thư mục của bạn
        Map params = ObjectUtils.asMap("public_id", fileNameWithoutExtension, "folder", folderName);
        Map response = cloudinary.uploader().upload(file, params);
        
        String publicUrl = cloudinary.url().format("png").version(response.get("version")).generate(fileNameWithoutExtension);
        String folderUrl = cloudinary.url().generate(folderName);
        String finalUrl = folderUrl + "/" + publicUrl.substring(publicUrl.lastIndexOf('/') + 1);
        
        System.out.println("Upload successful. Public URL: " + finalUrl);
        return finalUrl;
    }
    
    public static void main(String[] args) {
        // Đường dẫn của ảnh cần tải lên Cloudinary
        String urlPhoto = "path/to/your/photo.jpg";
        
        // Tạo một Runnable
        //Runnable uploader = new CloudinaryUploader(urlPhoto);
        
        // Tạo một luồng từ Runnable và thực thi
        //Thread thread = new Thread(uploader);
        //thread.start();
    }
}
