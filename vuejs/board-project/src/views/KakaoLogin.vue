<template>
    <div class="container">
        <h1>간단한 게시판</h1>
        <p v-if="!user.id">로그인을 진행하세요.</p>
        <div v-else>
            <PostForm @add-post="addPost">
                <template v-slot:header>
                    <div>Header</div>
                </template>
                <template #default>
                    <p>이름없는 slot</p>
                </template>
                <template v-slot:footer>
                    <div>&copy;since 1990</div>
                </template>
            </PostForm>
        </div>
        <hr />
        <PostList :posts="posts" />
        <a v-on:click="kakaoLogin()" id="custom-login-btn">
            <img src="../assets/kakao_logo.png" alt="" />
        </a>
    </div>
</template>

<script>
import PostList from "../components/PostList.vue";
import PostForm from "../components/PostForm.vue";

export default {
    // OptionsAPI 방식(객체활용)/ CompositionAPI 방식(함수기반)
    name: "App",
    components: {
        PostList,
        PostForm,
    },
    data() {
        return {
            user: { id: "", name: "" },
            //   posts: [], // 게시글 데이터를 담는 반응형(reactive) 데이터
        };
    },
    computed: {
        posts() {
            return this.$store.getters.getBoardList;
        },
    },
    methods: {
        addPost(newPost) {
            this.posts.push({
                id: this.posts.length + 1,
                title: newPost.title,
                content: newPost.content,
                date: new Date().toLocaleDateString(),
            });
        },
        kakaoLogin() {
            window.Kakao.Auth.login({
                scope: "profile_nickname, account_email",
                success: this.getKakaoAccount,
            });
        },
        getKakaoAccount() {
            window.Kakao.API.request({
                url: "/v2/user/me",
                success: (res) => {
                    console.log(res);
                    const kakao_account = res.kakao_account;
                    const nickname = kakao_account.profile.nickname;
                    const email = kakao_account.email;
                    console.log(nickname, email);
                    alert("success login");
                    // this.user = { id: email, name: nickname }; // 참조자체를 새로운 값.
                    this.user.id = email; // 속성변경해야지만 참조값이 변경X
                    this.user.name = nickname;
                    this.$store.commit("setId", email);
                },
                fail: (err) => {
                    console.log(err);
                },
            });
        },
    },
    provide() {
        return {
            user: this.user,
        };
    },
    mounted() {
        console.log(this.$store);
    },
};
</script>

<style scoped>
.container {
    max-width: 800px;
    margin: 0 auto;
    padding: 20px;
}
</style>
