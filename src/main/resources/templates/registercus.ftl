<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>业务注册</title>
</head>

<body>
<form id="form1" name="form1" method="post" action="register">
  <table width="343" border="1">
    <tr>
      <td width="126"><div align="right">token</div></td>
      <td width="201"><label for="token"></label>
      <input type="text" name="token" id="token" value="${token}" /></td>
    </tr>
    <tr>
      <td><div align="right">业务方名称</div></td>
      <td><label for=""></label>
      <input name="cname" type="text" id="cname" /></td>
    </tr>
    <tr>
      <td><div align="right">日总量</div></td>
      <td><label for=""></label>
      <input name="maxday" type="text" id="maxday" /></td>
    </tr>
    <tr>
      <td><div align="right">手机日上限</div></td>
      <td><label for="maxphone"></label>
      <input type="text" name="maxphone" id="maxphone" /></td>
    </tr>
    <tr>
      <td><div align="right">
        <input type="submit" name="button" id="button" value="提交" />
      </div></td>
      <td>&nbsp;</td>
    </tr>
  </table>
</form>
</body>
</html>
