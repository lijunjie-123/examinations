package org.yfcloud.examination.business.answerSheet.controller;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.yfcloud.examination.business.answerSheet.model.AnswerSheet;
import org.yfcloud.examination.business.answerSheet.service.AnswerSheetService;
import org.yfcloud.examination.business.test.model.Test;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/26 0026.
 */
@Controller
@RequestMapping("/answerSheet")
public class AnswerSheetCotroller {

    @Resource
    AnswerSheetService answerSheetServiceImpl;

    /**
     * 保存答案
     *
     * @param request
     * @param answerSheet
     * @param options
     * @param testIds
     * @return
     */
    @RequestMapping("/saveAnswerSheet")
    @ResponseBody
    public int saveAnswerSheet(HttpServletRequest request, AnswerSheet answerSheet, String options, String testIds, String paperId, String typeIds) {
        int state = 0;
        try {
            HttpSession session = request.getSession();
            Test test = (Test) session.getAttribute("user");
            String answerName = test.getName();
            String createUserId = test.getId();
            state = answerSheetServiceImpl.saveAnswerSheet(options, testIds, paperId, answerName, createUserId, typeIds);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return state;
    }

    //保存解答题分数
    @RequestMapping("/saveAnswerScore")
    @ResponseBody
    public int savesaveAnswerSheet(String answerQuestionsIds, String scores) {
        int state = 0;
        try {
            state = answerSheetServiceImpl.saveAnswerScore(answerQuestionsIds, scores);
        } catch (Exception e) {
            e.printStackTrace();
            state = -1;
        }
        return state;
    }

    @RequestMapping("/index")
    public ModelAndView answerUser() {
        ModelAndView view = new ModelAndView();
        try {
            view.setViewName("answerSheet/answerSheetIndex");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }


    //查询出考试成功的人
    @RequestMapping("/list")
    @ResponseBody
    public Map<String, Object> map(HttpServletRequest request, String answerName) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            int page = Integer.parseInt(request.getParameter("page"));
            int rows = Integer.parseInt(request.getParameter("rows"));
            Map<String, Object> param = new HashMap<String, Object>();
            param.put("start", (page - 1) * rows);
            param.put("rows", rows);
            param.put("answerName", answerName);
            List<AnswerSheet> list = answerSheetServiceImpl.getList(param);
            int count = answerSheetServiceImpl.getCount(param);
            result.put("rows", list);
            result.put("total", count);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    //下载考试成功人数据
    @RequestMapping("/download")
    public void download(HttpServletResponse response,HttpServletRequest request) {
        int type = Integer.parseInt(request.getParameter("type"));
        // 创建一个webbook，对应一个Excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        // 在webbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet("考试成绩表");


        //给标题设置样式
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        // 创建字体样式
        HSSFFont headerFont = wb.createFont();
        // 字体加粗
        headerFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        // 设置字体类型
        headerFont.setFontName("黑体");
        // 设置字体大小
        headerFont.setFontHeightInPoints((short) 10);
        // 为标题样式设置字体样式
        style.setFont(headerFont);

        //创建第一行
        HSSFRow row=sheet.createRow(0);
        // 设备标题的高度
        row.setHeightInPoints(20);






        //创建标题
        HSSFCell titleCell=row.createCell(0);
        titleCell.setCellValue("学员考试成绩一览表");
        titleCell.setCellStyle(style);

        //创建第二行
        HSSFRow row1=sheet.createRow(1);
        row1.createCell(0).setCellValue("姓名");
        row1.createCell(1).setCellValue("总分");


        // 合并单元格
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 1));


        if(type==0){
            int options = Integer.parseInt(request.getParameter("option"));
            //查出数据库内容写入Excle
            List<AnswerSheet> list = answerSheetServiceImpl.getAnswerSheetList(options);
            for(int i=0;i<list.size();i++){
                AnswerSheet answerSheet = list.get(i);

                row = sheet.createRow(i + 2);
                row.createCell(0).setCellValue(answerSheet.getAnswerName());
                row.createCell(1).setCellValue(answerSheet.getTotalScore());
            }
        }else {
            String startTime = request.getParameter("startTime");
            String endTime = request.getParameter("endTime");
            //查出数据库内容写入Excle
            List<AnswerSheet> list = answerSheetServiceImpl.getAnswerSheetList(startTime,endTime);
            for(int i=0;i<list.size();i++){
                AnswerSheet answerSheet = list.get(i);
                row.createCell(0).setCellValue(answerSheet.getAnswerName());
                row.createCell(1).setCellValue(answerSheet.getTotalScore());
            }
        }
          //输出Excel文件
        OutputStream output= null;
        try {
            output = response.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        response.reset();
        response.setHeader("Content-disposition", "attachment; filename=students.xls");
        response.setContentType("application/msexcel");
        try {
            wb.write(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
