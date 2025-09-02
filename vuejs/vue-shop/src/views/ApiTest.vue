<template>
    <div>{{ msg }}</div>
    <form>
        <input type="file" @change="getFileInfo" />
    </form>
</template>

<script>
import axios from "axios";
export default {
    data() {
        return {
            msg: "API Test",
        };
    },
    mounted() {
        axios
            .post("/api/productList", { param: [] }) // ✅ 첫번째는 url, 두번째는 data
            .then((result) => {
                console.log(result.data); // axios는 자동으로 JSON 파싱
            })
            .catch((err) => {
                console.error(err);
            });
    },
    methods: {
        getFileInfo(e) {
            console.log(e);
            const file_name = e.target.files[0].name; //
            const file = e.target.files[0];
            let fr = new FileReader();
            console.log(file_name);
            fr.onload = (ev) => {
                let base64Txt = ev.target.result;
                console.log(base64Txt.slice(base64Txt.indexOf(";base64") + 8));
                const data = base64Txt.slice(base64Txt.indexOf(";base64") + 8);
                axios.post("/upload/" + file_name, { param: data }).then((result) => console.log(result));
            };
            fr.readAsDataURL(file);
        },
    },
};
</script>

<style scoped></style>
