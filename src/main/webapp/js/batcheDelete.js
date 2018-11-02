/**   
    * 复选框变化  全选按钮变化   
        **/
function toChkSon(obj) {
    debugger
    var isCheck = obj.checked;
    obj.name = "check";
    //alert(obj.name);
    if (isCheck == false) //当此复选框未选中 全选为未选   
    {
        document.getElementById("chkMsgId").checked = false;
        obj.name = "user";
        return;
    }

    var chkInputs = getCheckBox(); //获取所有复选框   
    var j = 0;
    for (var i = 0; i < chkInputs.length; i++) {
        if (chkInputs[i].checked == isCheck)
            j++;
        else
            break;
    }

    // if (j == chkInputs.length) //当所有复选框为同一状态时 赋值全选同一状态   
    //     document.getElementById("chkMsgId").checked = isCheck;
}

/**   
  * 获取所有复选框   
     **/
function getCheckBox() {
    var inputs = document.getElementsByTagName("input");
    var chkInputs = new Array();
    var j = 0;
    for (var i = 0; i < inputs.length; i++) {
        if (inputs[i].type == "checkbox" && inputs[i].id != "chkMsgId") //刷选出所有复选框   
        {
            chkInputs[j] = inputs[i];
            j++;
        }
    }
    return chkInputs;
}

/**
   *提交表单
   */
function submitForm() {
    document.getElementById("myForm").submit();
}