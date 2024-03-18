/* 샘플 데이터 */
const getUserInfo = (userid, password) => {
    const reqData = {
        'userid' : userid,
        'password' : password
    }
    return {
        'data' : {
            'userId' : reqData.userId,
            'user_token' : 'user_test_token',
            'user_role' : 'ADM'
        }
    }
}

export default {
    async doLogin(userid, password) {
        try {
            const getUserInfoPromis = getUserInfo(userid, password)
            const [userInfoResponse] = await Promise.all([getUserInfoPromis])
            if(userInfoResponse.data.length == 0) {
                return 'notFound'
            } else {
                localStorage.setItem('user_token', userInfoResponse.data.user_token)
                localStorage.setItem('user_role', userInfoResponse.data.user_role)
                return userInfoResponse
            }
        } catch(err) {
            console.error(err)
        }
    }
}