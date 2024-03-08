const env = import.meta.env.MODE;



const url = {
    login : `/api/member/loginCheck_ajax`,              //로그인

    //게시판
    boardWrite : `/api/board/write`,                   //게시판 작성
    boardGetWrite : `/api/board/write_ajax`,            //게시판 글 작성(userid)
    boardPostWrite : `/api/board/listwrite_ajax`,          //글 작성

    //게시글
    List : `/api/board/view`,          //게시글 목록
    updateSampleView : `/api/board/view_ajax`,          //게시글 목록(테이블생성)
    getView : `/api/board/view_ajax`,          //게시글 상세보기
    getViewAjax : `/api/board/view_ajax`,          //게시글 상세보기 정보

    //댓글 목록
    postList : `/api/board/reply?option=L`,          //댓글 목록 불러오기
    postWrite : `/api/board/reply?option=I`,          //댓글 쓰기
    postModify : `/api/board/reply?option=U`,          //댓글 수정
    postDelete : `/api/board/reply?option=D`,          //댓글 삭제
    postLikeCheck : `/api/board/likeCheck`,          //댓글 삭제

}

export {
    url
}
