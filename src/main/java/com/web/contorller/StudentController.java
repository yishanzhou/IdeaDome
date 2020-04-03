package com.web.contorller;

import com.domain.Student;
import com.domain.Subject;
import com.github.pagehelper.PageInfo;
import com.service.StudentService;
import com.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("Student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("findAll")
    public PageInfo<Student> findAll(Integer page, Integer pageSize) {
        PageInfo<Student> all = studentService.findAll(page, pageSize);
        return all;
    }

    ;

    @RequestMapping("find")
    public List<Student> find() {
        List<Student> all = studentService.find();
        return all;
    }

    ;

    @RequestMapping("findName$Id")
    public Student findName$Id(String name, Integer id) {
        Student all = studentService.findName$Id(name, id);
        return all;
    }

    ;


    @RequestMapping("save")
    public String save(Student student, MultipartFile photo, HttpSession session) throws Exception {
        if (photo != null && !"".equals(photo.getOriginalFilename())) {
            //文件上传处理
            String oldName = photo.getOriginalFilename();
            //得到源文件的扩展名
            String ext = oldName.substring(oldName.lastIndexOf("."));
            //得新的名称
            String newName = UUID.randomUUID() + ext;
            //自己增加，每天上传的文件，对应一个文件夹2020-2-21
            //实际应用中，要考虑各种情况，本次例子中只讲了最简单的情况

            //得到绝对路径
            String realpath = session.getServletContext().getRealPath("upload") + "/" + newName;
            //保存
            photo.transferTo(new File(realpath));

            //将路径保存到user对象中
            student.setImg(newName);
        }

        boolean save = this.studentService.save(student);
        if (save) {
            return "保存成功";
        }
        return "保存失败";
    }
}
