<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<HTML>
<HEAD>
    <TITLE>EduSystem</TITLE>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/zTreeStyle/zTreeStyle.css" type="text/css">
    <style>
        body {
            background-color: white;
            margin:0; padding:0;
            text-align: center;
        }
        div, p, table, th, td {
            list-style:none;
            margin:0; padding:0;
            color:#333; font-size:12px;
            font-family:dotum, Verdana, Arial, Helvetica, AppleGothic, sans-serif;
        }
        #testIframe {margin-left: 10px;}
    </style>

    <script type="text/javascript" src="js/jquery/jquery-1.9.1.min_.js"></script>
    <script type="text/javascript" src="js/jquery/jquery.ztree.all-3.5.min.js"></script>

    <script type="text/javascript">

        <!--
        var zTree;
        var demoIframe;

        var setting = {
            view: {
                dblClickExpand: false,
                showLine: true,
                selectedMulti: false
            },
            data: {
                simpleData: {
                    enable:true,
                    idKey: "id",
                    pIdKey: "pId",
                    rootPId: ""
                }
            },
            callback: {
                beforeClick: function(treeId, treeNode) {
                    var zTree = $.fn.zTree.getZTreeObj("tree");
                    if (treeNode.isParent) {
                        zTree.expandNode(treeNode);
                        return false;
                    } else {
                        demoIframe.attr("src",treeNode.file + ".html");
                        return true;
                    }
                }
            }
        };

        var zNodes =[
            {id:1, pId:0, name:"test", open:true},
            {id:101, pId:1, name:"test--sub1"},
            {id:102, pId:1, name:"test--sub2"},

            {id:2, pId:0, name:"test1", open:false},
            {id:101, pId:2, name:"test--sub1"},
            {id:102, pId:2, name:"test--sub2"},

            {id:3, pId:0, name:"test2", open:false},
            {id:101, pId:3, name:"test--sub1"},
            {id:102, pId:3, name:"test--sub2"},

            {id:4, pId:0, name:"test3", open:false},
            {id:101, pId:4, name:"test--sub1"},
            {id:102, pId:4, name:"test--sub2"},

        ];

        $(document).ready(function(){
            var t = $("#tree");
            t = $.fn.zTree.init(t, setting, zNodes);
            demoIframe = $("#testIframe");
            demoIframe.bind("load", loadReady);
            var zTree = $.fn.zTree.getZTreeObj("tree");
            zTree.selectNode(zTree.getNodeByParam("id", 101));

        });

        function loadReady() {
            var bodyH = demoIframe.contents().find("body").get(0).scrollHeight,
                    htmlH = demoIframe.contents().find("html").get(0).scrollHeight,
                    maxH = Math.max(bodyH, htmlH), minH = Math.min(bodyH, htmlH),
                    h = demoIframe.height() >= maxH ? minH:maxH ;
            if (h < 530) h = 530;
            demoIframe.height(h);
        }

        //-->
    </script>

</head>
<BODY>
<TABLE border=0 height=600px align=left>
    <TR>
        <TD width=260px align=left valign=top style="BORDER-RIGHT: #999999 1px dashed">
            <ul id="tree" class="ztree" style="width:260px; overflow:auto;"></ul>
        </TD>
        <TD width=770px align=left valign=top><IFRAME ID="testIframe" Name="testIframe" FRAMEBORDER=0 SCROLLING=AUTO width=100%  height=600px ></IFRAME></TD>
    </TR>
</TABLE>

</BODY>
</html>
