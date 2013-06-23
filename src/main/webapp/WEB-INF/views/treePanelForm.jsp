<%@ page language="java" import="java.util.*" pageEncoding="Utf-8"%>
<html>
<head>
<title>Complex Layout</title>
<link rel="stylesheet" type="text/css" href="/EduSystem/resources/extjs/resources/css/ext-all.css" />

    <!-- GC -->

<style type="text/css">
p {
    margin:5px;
}
.settings {
    background-image:url(../shared/icons/fam/folder_wrench.png);
}
.nav {
    background-image:url(../shared/icons/fam/folder_go.png);
}
.info {
    background-image:url(../shared/icons/fam/information.png);
}
</style>
<script type="text/javascript" src="/EduSystem/resources/extjs/ext-all.js"></script>
<script type="text/javascript">
Ext.onReady(function(){
   Ext.QuickTips.init();
   
   var tabPanel = new Ext.TabPanel({
    					region: 'center',
    				    listeners:{
			                    tabchange:function(tab,newTab,oldTab){
			                	    var record = menuTree.getStore().getNodeById(newTab.getId());
			            			menuTree.getSelectionModel().select(record)
			                	}
               			}
   });
   
   var menuTree = new Ext.tree.TreePanel({
     useArrows:true,
     region: 'west',//指定布局
     animate:true,
     rootVisible:true,//不显示根节点
     width:200,
     store:Ext.create('Ext.data.TreeStore', {
        proxy: {
            type: 'ajax',
            url: '/EduSystem/getTree.do'
        },
        root: {
            text: 'Ext JS',
            id: 'src',
            expanded: true
        },
        folderSort: true,
        sorters: [{
            property: 'text',
            direction: 'ASC'
        }]
    }),
     listeners:{
       'itemclick':function(view,node){
       	 var randomnumber=Math.floor(Math.random()*100000);//作为地址的传递参数 以使每次访问时重新获取数据 而非缓存中信息
       	 var tab = Ext.get(node.getId());
       	 if(node.get('leaf')==true){
       	 	if(tab == null){
       	 		var subTabPanel = new Ext.Panel({
       	 		  id:node.getId(),
	    		  title:node.get('text'),
	    		  closable:true,
       	 		  html:'<iframe id="iframe_'+node.getId()+'" name="iframe_'+node.getId()+'" scrolling="auto" frameborder="0" width="100%" height="100%" src="'+node.raw.url+"?random="+randomnumber+'"></iframe>'
       	 		});
       	 		tabPanel.add(subTabPanel);//添加该panel
       	 		tabPanel.setActiveTab(node.getId());//激活它
       	 		
       	 	}else{
       	 		tabPanel.setActiveTab(node.getId());//如果已经存在 则激活它
       	 	}
       	 }
       }
     }
     
   });
   
   var viewPort = new Ext.Viewport({
   	layout:'border',
    items:[menuTree,tabPanel]//放进去才开始加载菜单项
   });
});
</script>
</head>
<body>
</body>
</html>
