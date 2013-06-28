<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title></title>
<script src="${path}/resources/extjs/ext-all.js" type="text/javascript"></script>
<link href="${path}/resources/extjs/resources/css/ext-all.css" rel="stylesheet" type="text/css" />
   
</head>
<script type="text/javascript">
    Ext.onReady(function () {
        
    	
    
        var states = [
						    {"value":"0","name":"学员"},
						    {"value":"1","name":"辅导老师"},
						    {"value":"2","name":"子管理员"},
						    {"value":"3","name":"管理员"}
					 ];
    
        var logf = new Ext.FormPanel({
            renderTo: "log",
            title: "用户登录",
            width: 300,
            //method:'GET',
            height: 150,
            frame: true,
            floating: true,
            defaultType: "textfield",
            labelAlign: "right",
            url:'${path}/dologin.do',
            items: [
            {
                fieldLabel: "用户名",
                name:'identityCard'
                
            },
            {
                inputType: "password",
                fieldLabel: "密码",
                name:'password'
            },
            {
                    xtype: 'combobox',
                    fieldLabel: '用户类型',
                    name: 'state',
                    store: Ext.create('Ext.data.Store', {
                        fields: ['value','name'],
                        data : states
                    }),
                    valueField: 'value',
                    displayField: 'name',
                    typeAhead: true,
                    emptyText: '请选择'
            }],
            buttons: [
	            { text: "登录", 
	              handler: function() {
				                var form = this.up('form').getForm();
				                form.submit({
				                    success: function(form, action) {
				                    	location.href='${path}/home.do';
				                    },
				                    failure: function(form, action) {
				                    	var msg = Ext.decode(action.response.responseText);
				                        Ext.Msg.alert('提示', msg.msg);
				                    }
				                });
				        }
	              }
            ]
 

        });
        //end
        var vp = new Ext.Viewport();
        var x = (vp.getSize().width - logf.getSize().width) / 2;
        var y = (vp.getSize().height) / 2- logf.getSize().height;
        logf.setPosition(x, y);
    })
</script>
<body>
<div id="log"></div>
</body>
</html>