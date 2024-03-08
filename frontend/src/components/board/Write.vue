<template>
  <h1>BOARD WRITE</h1>
  <hr>
  <div>
    <div>
      제목 : <input type="text" placeholder="제목을 입력해주세요" v-model="title">
    </div>
    <hr>
    <div>
      작성자 : <input type="text" placeholder="작성자를 입력해주세요" v-model="author">
    </div>
    <hr>
    <div>
      <textarea id="" cols="30" rows="10" v-model="contents"></textarea>
    </div>
    <hr>
  </div>
  <div>
    <button type="button" @click="updateBoard">저장</button>
    <button type="button" @click="goList">목록</button>
  </div>

</template>

<script>
  export default {
    data() {
      return {
        requestBody : this.$route.query,
        seq : this.$route.query.seq,

        title : '',
        author : '',
        contents : '',
        create_dt : '',
      }
    },
    mounted() {
      this.getBoardList()
    },
    methods : {
      getBoardList() {
        if(this.seq !== undefined) {
          this.$axios.get(this.$serverUrl + '/board/' + this.seq, {
            params : this.requestBody
          }).then((res) => {
            this.title = res.data.title
            this.author = res.data.author
            this.contents = res.data.contents
          })
        }
      },
      goList() {
        delete this.requestBody.seq
        this.$router.push({
          path : './List',
          query : this.requestBody
        })
      },
      getBoardDetail(seq) {
        this.requestBody.seq = seq
        this.$router.push({
          path : './Detail',
          query : this.requestBody
        })
      },
      updateBoard() {
        let apiUrl = this.$serverUrl + '/board'
        this.form = {
          "seq" : this.seq,
          "title" : this.title,
          "contents" : this.contents,
          "author" : this.author
        }

        if(this.seq === undefined) {
          /* INSERT */
          this.$axios.post(apiUrl, this.form)
              .then((res)=>{
                alert("글이 저장되었습니다.");
                this.getBoardDetail(res.data.seq)
              })
        } else {
          /* UPDATE */
          this.$axios.patch(apiUrl, this.form)
              .then((res)=> {
                alert("글이 수정되었습니다.");
                this.getBoardDetail(res.data.seq)
              })
        }
      }
    }
  }
</script>

<style scoped>

</style>