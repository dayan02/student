$(function () {
    loadData();
})
function loadData() {   // 定义数据读取的操作函数
    $.post("pages/back/student/student_list.action", {"cp": jsCommonCp, "ls": jsCommonLs}, function (obj) {
        
    	/*alert("Nihao");*/
    	
    	for(var x=0;x<=obj.allStudent.length;x++ ){
    	
    		addRow(obj.allStudent[x].sid,obj.allStudent[x].name,obj.allStudent[x].age,obj.allStudent[x].sex,obj.allStudent[x].address)
    	}
    	
    	createSplitBar(obj.allRecorders);
    }, "json");
}


function addRow(sid,name,age,sex,address,cid) {
    var str = "<tr><td><input type='checkbox' class='text-center' name='sid' id='sid' value='"+sid+"'></td>" +
        "<td class='text-center' id='sid-"+sid+"'>"+sid+"</td>" +
        "<td class='text-center' id='name-"+sid+"'>"+name+"</td>" +
        "<td class='text-center' id='age-"+sid+"'>"+age+"</td>" +
        "<td class='text-center' id='sex-"+sid+"'>"+sex +"</td>"+
        "<td class='text-center' id='address-"+sid+"'>"+address+"</td>" +
        "<td class='text-center'><button type='button' class='btn btn-success btn-sm' data-toggle='modal' data-target='#studentInfo' id='"+ sid +"-"+ cid +"'>修改</button> </td>" +
        "</tr>";
    $("#studentTable").append($(str));
}

