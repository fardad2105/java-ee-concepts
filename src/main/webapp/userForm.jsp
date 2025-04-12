<a href="viewUsers.jsp">View All Users</a>

<h1>Add New User</h1>
<form action="addUserForm.jsp" method="post">
    <table>
        <tr>
            <td>Name:</td>
            <td><label><input type="text" name="name"/></label></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><label><input type="password" name="password"></label></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><label><input type="email" name="email"></label></td>
        </tr>
        <tr>
            <td>Sex:</td>
            <td>
                <label>
                    <input type="radio" name="sex" value="male">
                </label>
                <label>
                    <input type="radio" name="sex" value="female">
                </label>
            </td>
        </tr>
        <tr>
            <td>Country</td>
            <td>
                <label>
                    <select name="country" style="width: 200px">
                        <option>Iran</option>
                        <option>USA</option>
                        <option>Turkish</option>
                        <option>Spain</option>
                        <option>Other</option>
                    </select>
                </label>
            </td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Add User"></td>
        </tr>
    </table>
</form>