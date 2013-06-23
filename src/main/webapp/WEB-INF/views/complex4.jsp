<%@ page language="java" import="java.util.*,java.net.*" pageEncoding="utf-8"%>
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
    Ext.require(['*']);
    Ext.onReady(function() {
    Ext.QuickTips.init();
    var params={};
	Ext.define('ForumThread', {
	        extend: 'Ext.data.Model',
	        fields: [
	            'title', 'forumtitle', 'forumid', 'username',
	            {name: 'replycount', type: 'int'},
	            {name: 'lastpost', mapping: 'lastpost', type: 'date', dateFormat: 'timestamp'},
	            'lastposter', 'excerpt', 'threadid'
	        ],
	        idProperty: 'threadid'
	    });
	    
	    function renderLast(value) {
	        return Ext.Date.dateFormat(value, 'Y-m-d');
	    }
	
	    var store = Ext.create('Ext.data.Store', {
	        pageSize: 20,
	        model: 'ForumThread',
	        remoteSort: true,
	        proxy: {
	            // load using script tags for cross domain, if the data in on the same domain as
	            // this page, an HttpProxy would be better
	            type: 'ajax',
	            url: '/EduSystem/getJson.do',
	            //getMethod: function(){ return 'POST';},
	            reader: {
	                root: 'topics',
	                totalProperty: 'totalCount'
	            },
	            // sends single sort as multi parameter
	            simpleSortMode: true
	        },
	        sorters: [{
	            property: 'lastpost',
	            direction: 'DESC'
	        }],
	        listeners: {
		        beforeload: function(store, operation, eOpts) {
			        store.getProxy().extraParams = params;
		      }
		  }
	    });
	    
	    
	    var EditForm=Ext.create('Ext.form.Panel', {
							            id:'editForm',
								    	region: 'north',
							            labelAlign : 'right',
							            buttonAlign : 'center',
							            frame : true,
							            labelWidth : 20,
							            url:'/EduSystem/getForm.do',
									    items: [{
									        xtype: 'textfield',
									        fieldLabel: 'topic',
									        name: 'title'
									    }],
									    buttons: [{
									        text: '修改',
									        handler: function() {
									            // The getForm() method returns the Ext.form.Basic instance:
									            var form = this.up('form').getForm();
									            if (form.isValid()) {
									                form.submit({
									                    success: function(form, action) {
									                       Ext.Msg.alert('提示', '修改成功');
									                       Ext.getCmp('editWin').hide();
									                    },
									                    failure: function(form, action) {
									                        Ext.Msg.alert('提示', '服务正忙，请稍后访问！');
									                    }
									                });
									            }
									        }
									    }]
								 });
	    
	    
	    
	    var win=new Ext.create('Ext.window.Window', {
	                        id:'editWin',
						    title: '内容修改',
						    width: 500,
						    closeAction:'hide',
						    items: [{
						        xtype: 'form',
						        height:200,
						        layout:'fit',
						        items:[
							        EditForm
						       ]
						    }]
						});
	    
	    var grid = Ext.create('Ext.grid.Panel', {
	        layout:'fit',
	        region:'center',
	        title: '查询结果',
	        store: store,
	        disableSelection: true,
	        loadMask: true,
	        columns:[{
	            id: 'topic',
	            text: "Topic",
	            dataIndex: 'title',
	            flex: 1,
	            sortable: false
	        },{
	            text: "Author",
	            dataIndex: 'username',
	            width: 100,
	            //hidden: true,
	            sortable: true
	        },{
	            text: "Replies",
	            dataIndex: 'replycount',
	            width: 70,
	            align: 'right',
	            sortable: true
	        },{
	            id: 'last',
	            text: "Last Post",
	            dataIndex: 'lastpost',
	            width: 150,
	            renderer: renderLast,
	            sortable: true
	        },
	        {
                menuDisabled: true,
                sortable: false,
                text:'操作',
                xtype: 'actioncolumn',
                width: 50,
                items: [{
                    icon   : '../shared/icons/fam/delete.gif',  // Use a URL in the icon config
                    tooltip: 'Sell stock',
                    handler: function(grid, rowIndex, colIndex) {
                        var rec = store.getAt(rowIndex);
                        alert("Sell " + rec.get('title'));
                    }
                }, {
                    getClass: function(v, meta, rec) {          // Or return a class from a function
                        if (rec.get('title') =='0') {
                            this.items[1].tooltip = 'Hold stock';
                            return 'alert-col';
                        } else {
                            this.items[1].tooltip = 'Buy stock';
                            return 'buy-col';
                        }
                    },
                    handler: function(grid, rowIndex, colIndex) {
                        var rec = store.getAt(rowIndex);
                        alert((rec.get('title') < 0 ? "Hold " : "Buy ") + rec.get('title'));
                    }
                }]
            }
	        ],
	        bbar: Ext.create('Ext.PagingToolbar', {
	            store: store,
	            displayInfo: true,
	            displayMsg: 'Displaying topics {0} - {1} of {2}',
	            emptyMsg: "No topics to display"
	        }),
	        listeners:{
	            'itemdblclick':function(view,record,item,index){
	                win.show();
	                Ext.getCmp('editForm').getForm().loadRecord(record);
	        	}
	        }
	    });
	    store.load();
        
		
	var simpleForm = new Ext.FormPanel({
	        id:'selectForm',
	    	region: 'north',
            labelAlign : 'right',
            title : '查询条件',
            buttonAlign : 'center',
            bodyStyle : 'padding:5px 5px 5px 5px',
            frame : true,
            labelWidth : 20,
            items : [{
                        layout : 'column', // 定义该元素为布局为列布局方式
                        border : false,
                        labelSeparator : '：',
                        items : [{
                                    columnWidth : .25, // 该列占用的宽度，标识为50％
                                    layout : 'form',
                                    border : false,
                                    items : [{ // 这里可以为多个Item，表现出来是该列的多行
                                        cls : 'key',
                                        xtype : 'datefield',
                                        fieldLabel : '检查日期',
                                        format:'Y-m-d',
                                        name : 'jcri1',
                                        anchor : '90%',
                                        allowBlank:false, //不允许为空
                                        blankText:'不能为空'
                                    }]
                                }, {
                                    columnWidth : .25, // 该列占用的宽度，标识为50％
                                    layout : 'form',
                                    border : false,
                                    items : [{ // 这里可以为多个Item，表现出来是该列的多行
                                        cls : 'key',
                                        xtype : 'datefield',
                                        format:'Y-m-d',
                                        fieldLabel : '至',
                                        name : 'jcrq2',
                                        anchor : '90%',
                                        allowBlank:false, //不允许为空
                                        blankText:'不能为空'
                                    }]
                                },{
                                    columnWidth : .25, // 该列占用的宽度，标识为50％
                                    layout : 'form',
                                    border : false,
                                    items : [{ // 这里可以为多个Item，表现出来是该列的多行
                                        cls : 'key',
                                        xtype : 'textfield',
                                        fieldLabel : '邮箱',
                                        name : 'yx',
                                        anchor : '90%',
                                        vtype:"email",//email格式验证
						                vtypeText:"不是有效的邮箱地址",//错误提示信息,默认值我就不说了
						                maxLength:20,
						                maxLengthText:"太长了"
                                    }]
                                },
				{
                                    columnWidth : .25,
                                    layout : 'form',
                                    border : false,
                                    items : [{
                                                id:'shuzi',
                                                cls : 'key',
                                                xtype : 'textfield',
                                                fieldLabel : '数字',
                                                name : 'mima',
                                                anchor: '90%',
                                                regex: /[\u4e00-\u9fa5]/,
												regexText:'只能数字组成！'
                                            }]
                                }]
                    },{
                        layout : 'column', // 定义该元素为布局为列布局方式
                        border : false,
                        labelSeparator : '：',
                        items : [{
                                    columnWidth : .5, // 该列占用的宽度，标识为50％
                                    layout : 'form',
                                    border : false,
                                    items : [{ // 这里可以为多个Item，表现出来是该列的多行
                                        cls : 'key',
                                        xtype : 'textfield',
                                        fieldLabel : '任务名称',
                                        name : 'renwu',
                                        anchor : '90%'
                                    }]
                                }, {
                                    columnWidth : .25,
                                    layout : 'form',
                                    border : false,
                                    items : [{
                                                cls : 'key',
                                                xtype : 'textfield',
                                                inputType : 'password',
                                                fieldLabel : '被检查人',
                                                name : 'bjcr',
                                                anchor : '90%'
                                            }]
                                },
				{
                                    columnWidth : .25,
                                    layout : 'form',
                                    border : false,
                                    items : [{
                                                cls : 'key',
                                                xtype : 'textfield',
                                                inputType : 'password',
                                                fieldLabel : 'jcbm',
                                                name : 'jcbm',
                                                anchor : '90%'
                                            }]
                                }]
                    }],
					buttons: [{
						text: '查询',
						handler: function(){
						    if(!Ext.getCmp("shuzi").isValid()){
						    	Ext.Msg.alert('提示','请正确填写表单！');
						    }else{
							    params={
							    	jcbm:Ext.encode(Ext.getCmp('shuzi').getValue())
							    }
							    store.loadPage(1);
						    }
					    }
					}]
        });


        // NOTE: This is an example showing simple state management. During development,
        // it is generally best to disable state management as dynamically-generated ids
        // can change across page loads, leading to unpredictable results.  The developer
        // should ensure that stable state ids are set for stateful components in real apps.
        Ext.state.Manager.setProvider(Ext.create('Ext.state.CookieProvider'));

        var viewport = Ext.create('Ext.Viewport', {
            id: 'border-example',
            layout: 'border',
            items: [
		simpleForm,
                grid
            ]
        });
    });
    </script>
</head>
<body>
</body>
</html>

