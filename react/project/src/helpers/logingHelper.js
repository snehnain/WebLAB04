const logingHelper = (username, password) =>
{
    if(username ==='admin' && password === 'adminPwd')
        return true;
    else
        return false;
}

export default logingHelper;
