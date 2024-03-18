import {createStore} from "vuex";
import getters from "./getters";
import mutations from "./mutation";
import actions from "@/vuex/actions.js";

/*
* Store : 어플리케이션 상태를 보유하고 있는 컨테이너
*
*/

export default createStore({
    state : {
        /*
        * state : 여러 컴포넌트 간에 공유되는 데이터를 의미
        *   - 정의
        *   new Vuex.Store({
        *       state : {
        *           message : 'hello Vue.js'
        *   })
        *   - 접근
        *       <div>{{ $store.state.message }} </div>
        */
        user : null,
        isLogin : false,
    },
    mutations,
    /*
        mutations : vuex에서 상태 값을 변경하는 유일한 방법으로 상태는 항상 뮤테이션으로 변경된다.
            - 정의
            new Vuex.Store({
                mutations : {
                    reverserMessage(state) {
                        state.message.split('').reverse().join('');
                    }
                }
            })
            - 호출
            new Vue({
                methods : {
                    reverseMsg() {
                        this.$store.commit('reverseMessage');
                    }
                }
            }
    */

    getters,
    /*
        getters : computed 속성과 같은 역할, 상태(state) 값이 변경되었을 때 변화에 따른 차이를 자동으로 반영하여 값을 계산해 줌
            - 정의
            new Vuex.Store({
                getters : {
                    reverserMessage(state) {
                        return state.message.split('').reverse().join('');
                    }
                }
            })
            - 접근
            <div>{{ $store.getters.reverseMessage }}</div>
    */

    actions,
})