<template>
    <div>{{ msg }}</div>
    <table class="add">
        <tr>
            <th>상품명</th>
            <td><input type="text" v-model="product_name" /></td>
        </tr>
        <tr>
            <th>가격</th>
            <td><input type="text" v-model="product_price" /></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><button v-on:click="insertProduct">상품등록</button></td>
        </tr>
    </table>
    <br />
    <table class="list">
        <thead>
            <tr>
                <th>상품번호</th>
                <th>상품명</th>
                <th>가격</th>
                <th>Category</th>
            </tr>
        </thead>
        <tbody>
            <tr v-bind:key="i" v-for="(list, i) in prodList">
                <td>{{ list.id }}</td>
                <td>{{ list.product_name }}</td>
                <td>{{ list.product_price }}</td>
                <td>{{ list.category1 + "," + list.category2 + "," + list.category3 }}</td>
            </tr>
        </tbody>
    </table>
</template>

<script>
import axios from "axios";
export default {
    data() {
        return {
            msg: "Axios 연습",
            prodList: [],
            product_name: "",
            product_price: 5000,
        };
    },
    methods: {
        async getProductList() {
            let response = await axios.post("http://localhost:3000/api/productList", []);
            return response.data.result;
        },

        async insertProduct() {
            let product = {
                product_name: this.product_name,
                product_price: this.product_price,
                seller_id: 1,
                category_id: 1,
            };
            // let response = await
            let response = await axios.post("http://localhost:3000/api/productInsert", { param: [product] });
            console.log(response);
            response = await this.getProductList();
            this.prodList = response;
        },
    },
    mounted() {
        this.getProductList().then((list) => (this.prodList = list));
    },
};
</script>

<style scoped>
table.add {
    width: 60%;
    margin: auto;
    border-collapse: collapse;
}
table.list {
    width: 100%;
    margin: auto;
    border-collapse: collapse;
}
.list th,
.list td {
    border: 2px solid green;
}
.add th,
.add td {
    border: 2px solid pink;
}
</style>
