<template>
    <div>
        <h3>{{ msg1 }}</h3>
        <table>
            <thead>
                <tr>
                    <th>이름</th>
                    <th>이름</th>
                    <th>나이</th>
                </tr>
            </thead>
            <tbody>
                <!-- data에서 가져와 for문을 돌리는데 prod에 할당, prod.id를 키로 잡아서 for문을 돌려줘야함 -->
                <tr v-bind:key="prod.id" v-for="prod in data">
                    <!-- 아래와 같이 i를 index로 잡아서 index를 key로 잡아도 됨 -->
                    <!-- <tr v-bind:key="i" v-for="(prod, i) in data"> -->
                    <td>{{ prod.id }}</td>
                    <td v-text="prod.name"></td>
                    <td>{{ prod.age }}</td>
                </tr>
            </tbody>
        </table>
    </div>
    <div>
        <h3>{{ msg2 }}</h3>
        <table>
            <thead>
                <tr>
                    <th>상품명</th>
                    <th>가격</th>
                    <th>카테고리</th>
                    <th>배송비</th>
                </tr>
            </thead>
            <tbody>
                <!-- data에서 가져와 for문을 돌리는데 prod에 할당, prod.id를 키로 잡아서 for문을 돌려줘야함 -->
                <!-- <tr v-bind:key="prod.id" v-for="prod in data"> -->
                <!-- 아래와 같이 i를 index로 잡아서 index를 key로 잡아도 됨 -->
                <tr v-bind:key="i" v-for="(prod, i) in productList">
                    <td>{{ prod.product_name }}</td>
                    <td>{{ prod.price }}</td>
                    <td>{{ prod.category }}</td>
                    <td>{{ prod.delivery_price }}</td>
                </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
export default {
    data() {
        return {
            msg1: "학생목록",
            msg2: "상품목록",
            data: [
                { id: 1, name: "홍길동", age: 20 },
                { id: 1, name: "김민수", age: 22 },
                { id: 1, name: "최익수", age: 25 },
            ],
            productList: [],
        };
    },
    mounted() {
        //컴포넌트가 생성되면 생성, 마운트, 소멸 등등 각각의 시점에 기능을 추가 가능
        fetch("http://192.168.0.83:3000/products")
            .then((response) => response.json())
            .then((result) => {
                this.productList = result;
            });
    },
};
</script>

<style scoped></style>
