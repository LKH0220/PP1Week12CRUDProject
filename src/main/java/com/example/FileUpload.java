package com.example;

import com.example.bean.ContactVO;
import com.example.dao.ContactDAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

public class FileUpload {
    public ContactVO uploadImage(HttpServletRequest request){
        String filename=""; // 업로드되는 파일 이름을 저장함
        int sizeLimit = 15 * 1024 * 1024; //파일 크기 15MB로 제한
        String realPath = request.getServletContext().getRealPath("upload"); //서버에 파일이 저장되는 path를 정함
        System.out.println(realPath);

        //저장될 경로가 존재하지 않을시 새로 생성
        File dir = new File(realPath);
        if(!dir.exists()) dir.mkdirs();

        ContactVO one = null;
        MultipartRequest multipartRequest = null;
        try {
            //파일 업로드 처리 과정
            //파라미터 : request, 저장 경로, 최대 용량, 인코딩, 중복파일명정책
            multipartRequest = new MultipartRequest(request, realPath, sizeLimit, "utf-8", new DefaultFileRenamePolicy());

            //"image"라는 이름으로 전송되어 업로드된 파일 이름을 가져옴
            filename = multipartRequest.getFilesystemName("image");

            one = new ContactVO();
            String contactID = multipartRequest.getParameter("contactID");
            if(contactID!=null&&!contactID.equals(""))one.setContactID(Integer.parseInt(contactID));
            one.setContactName(multipartRequest.getParameter("contactName"));
            one.setContactPhone(multipartRequest.getParameter("contactPhone"));
            one.setContactEmail(multipartRequest.getParameter("contactEmail"));
            one.setContactBirthday(multipartRequest.getParameter("contactBirthday"));

            if(contactID!=null&&!contactID.equals("")){ //edit 인 경우 기존 파일이름과 비교
                ContactDAO dao = new ContactDAO();
                String oldfilename = dao.getImageFilename(Integer.parseInt(contactID));
                if(filename!=null && oldfilename!=null) //새로 덮어씌울 파일이 전송된 경우 이전 파일을 제거
                    FileUpload.deleteFile(request, oldfilename);
                else if (filename==null && oldfilename!=null) //새로운 파일이 없는 경우 이전 파일을 유지
                    filename = oldfilename;
            }
            one.setImage(filename);
        }catch (IOException e) {
            e.printStackTrace();
        }
        return one;
    }

    public static void deleteFile(HttpServletRequest request, String filename) {
        String filePath = request.getServletContext().getRealPath("upload");

        File f = new File(filePath + "/" + filename);
        if(f.exists()) f.delete();
    }
}
