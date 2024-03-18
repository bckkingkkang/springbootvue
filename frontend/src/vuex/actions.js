import {USER_ID, IS_AUTH, ERROR_STATE} from "@/vuex/mutation_types.js";
import loginAPI from "@/service/loginAPI.js";

let setUserId = ({commit}, data) => {
    commit(USER_ID, data)
}

let setErrorState = ({commit}, data) => {
    commit(ERROR_STATE, data)
}

let setIsAuth = ({commit}, data) => {
    commit(IS_AUTH, data)
}

// 백엔드에서 로그인 성공 여부 반환값을 vuex에 넣기
let processResponse = (store, loginResponse) => {
    switch (loginResponse) {
        case 'notFound' :
            setErrorState(store, 'Wrong ID or Password')
            setIsAuth(store, false)
            break;
        default :
            setUserId(store, loginResponse.userid)
            setErrorState(store, '')
            setIsAuth(store, true)
    }
}

export default {
    async login(store, {userid, password}) {
        let loginResponse = await loginAPI.doLogin(userid, password)
        processResponse(store, loginResponse)
        return store.getters.getIsAuth
    }
}