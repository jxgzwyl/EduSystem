<%
String start = request.getParameter("start");
String limit = request.getParameter("limit");
String jcbm = request.getParameter("jcbm");
System.out.println(jcbm);
try {
    int index = 0;
    int pageSize = 20;

    String json = "{totalCount:100,topics:[";
    for (int i = index; i < pageSize + index; i++) {
        json += "{title:\"" + i + "\",threadid:\"name" + i + "\",username:\"descn" + i + "\",";
        json += "userid:\"272497\",dateline:\"1305604761\",postid:\"602876\",forumtitle:\"rtegds\",forumid:\"40\",replycount:\"2\",lastpost:\"1305857807\",lastposter:\"kpr@emco\",excerpt:\"fdsaf\"}";
        if (i != pageSize + index - 1) {
            json += ",";
        }
    }
    json += "]}";
    response.getWriter().write(json);
} catch(Exception ex) {
}
%>