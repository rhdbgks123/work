import { createStore } from "vuex";

export default createStore({
    state: {
        boardList: [
            {
                id: 1,
                title: "게시글 1번",
                content: "등록연섭",
                date: new Date().toLocaleDateString(),
                writer: "user01",
            },
        ],
        logId: "",
    },
    // mutations는 동기방식 처리 java에서는 mapper같은 느낌
    mutations: {
        addBoard(state, post) {
            state.boardList.push(post);
        },
        setId(state, id) {
            state.logId = id;
        },
    },
    // actions는 비동기방식 처리 java에서는 service같은 느낌
    actions: {
        // context = {commit, dispatch, getter} // {commit}은 context에서 commit만 가져오겟다. context.commit과 동일한 사용법
        saveBoard({ commit }, post) {
            commit("addBoard", post);
        },
    },
    getters: {
        getBoardList(state) {
            return state.boardList;
        },
        getBoardNo(state) {
            return state.boardList.length + 1;
        },
        getLogId(state) {
            return state.logId;
        },
    },
});
