<template>
    <div class="post-item">
        <h3>{{ post.title }}</h3>
        <p>{{ post.content }}</p>
        <small>작성일: {{ post.date }}</small>
        <p>작성자: {{ post.writer }}</p>
    </div>
</template>

<script>
export default {
    data() {
        return {
            msg: "",
        };
    },
    props: {
        post: { type: Object, default: () => {} },
    },
    inject: ["user"],
    mounted() {
        console.log(this.user);
    },
};
</script>

<style>
.post-item {
    border: 1px solid #ccc;
    padding: 15px;
    margin-bottom: 15px;
    border-radius: 8px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}
</style>
