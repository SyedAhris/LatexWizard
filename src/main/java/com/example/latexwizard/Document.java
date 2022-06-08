package com.example.latexwizard;

import java.io.*;

public class Document {
    private String title;
    private String subTitle;
    private String instructorName;
    private String semDate;
    private String body;
    private String path;
    private String fileName;
    public Document () {}

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public String getSemDate() {
        return semDate;
    }

    public void setSemDate(String semDate) {
        this.semDate = semDate;
    }

    public boolean checkPath () {
        boolean isFile = false;
        try {
            File myObj = new File(path + "\\" + fileName + ".tex");
            System.out.println(path + "\\" + fileName + ".tex");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                isFile = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
            isFile = true;
        }
        return isFile;
    }

    public void createTexFile() throws IOException {
        File file = new File(path + "/" + fileName + ".tex");
        FileOutputStream fos = new FileOutputStream(file);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        bw.write("\\documentclass[a4paper]{article}\n" +
                "\n" +
                "\\usepackage[english]{babel}\n" +
                "\\usepackage[utf8]{inputenc}\n" +
                "\\usepackage{amsmath}\n" +
                "\\usepackage{graphicx}\n" +
                "\\usepackage[colorinlistoftodos]{todonotes}\n" +
                "\\usepackage[obeyspaces]{url}\n" +
                "%\\usepackage{hyperref}\n" +
                "\n" +
                "\\usepackage{setspace}\n" +
                "\\usepackage{listings}\n" +
                "\\usepackage{xcolor}\n" +
                "\n" +
                "\\definecolor{codegreen}{rgb}{0,0.6,0}\n" +
                "\\definecolor{codeblue}{rgb}{0,0,0.6}\n" +
                "\\definecolor{codegray}{rgb}{0.5,0.5,0.5}\n" +
                "\\definecolor{codepurple}{rgb}{0.58,0,0.82}\n" +
                "\\definecolor{backcolour}{rgb}{0.95,0.95,0.92}\n" +
                "\n" +
                "\\lstset{language=Java,\n" +
                "\tbackgroundcolor=\\color{backcolour},\n" +
                "\tbackgroundcolor=\\color{backcolour},   \n" +
                "\tcommentstyle=\\color{codegreen},\n" +
                "\tkeywordstyle=\\color{magenta},\n" +
                "\tnumberstyle=\\tiny\\color{codegray},\n" +
                "\tstringstyle=\\color{codepurple},\n" +
                "\tbasicstyle=\\ttfamily\\footnotesize,\n" +
                "\tbreakatwhitespace=false,         \n" +
                "\tbreaklines=true,                 \n" +
                "\tcaptionpos=b,                    \n" +
                "\tkeepspaces=true,                 \n" +
                "\tnumbers=left,                    \n" +
                "\tnumbersep=5pt,                  \n" +
                "\tshowspaces=false,                \n" +
                "\tshowstringspaces=false,\n" +
                "\tshowtabs=false,                  \n" +
                "\ttabsize=2\n" +
                "}");
        bw.newLine();
        bw.write("\\title{" + title + "\\\\ \\vspace{5mm}");
        bw.newLine();
        bw.write("  \\large " + subTitle + "}");
        bw.newLine();
        bw.write("\\author{Instructor: " + instructorName + "}");
        bw.newLine();
        bw.write("\\date{" + semDate + "}");
        bw.newLine();
        bw.write("\\begin{document}");
        bw.newLine();
        bw.write("\\maketitle");
        bw.newLine();
        bw.write(body);
        bw.newLine();
        bw.write("\\end{document}");
        bw.close();
    }
}
