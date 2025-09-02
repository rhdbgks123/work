<template>
    <div>
        <p>FirstName: <input type="text" v-model="fname" /></p>
        <p>LastName: <input type="text" v-model="lname" /></p>
        <p>FullName: {{ FullName }}</p>
    </div>
    <div>
        <p v-bind:key="i" v-for="(fruit, i) in cartList">
            <strong>{{ fruit.pname }}</strong> - 가격 : {{ fruit.price }} - 수량 :
            <input type="number" v-model="fruit.qty" />
        </p>
        <p>
            <strong>총수량 : {{ totalQuantity }}개</strong>
        </p>
        <p>
            <strong>합계금액 : {{ totalPrice }}원</strong>
        </p>
    </div>
    <div>
        <h3>Watch 속성 변경이전, 변경이후 값을 처리</h3>
        <p>
            <strong>{{ changeName }}</strong>
        </p>
        <!-- v-on:click == @click -->
        <button @click="changeNaming">change</button>
    </div>
</template>

<script>
export default {
    data() {
        return {
            msg: "",
            fname: "kildong",
            lname: "Hong",
            cartList: [
                { id: 1, pname: "사과", price: 1000, qty: 2 },
                { id: 2, pname: "포도", price: 2000, qty: 3 },
                { id: 3, pname: "수박", price: 3000, qty: 1 },
            ],
            changeName: "Hong",
        };
    },
    computed: {
        // 계산된속성
        FullName() {
            return this.fname + "/" + this.lname;
        },
        totalQuantity() {
            return this.cartList.reduce((acc, item) => {
                return acc + item.qty;
            }, 0);
        },
        totalPrice() {
            return this.cartList.reduce((acc, item) => {
                return acc + item.price * item.qty;
            }, 0);
        },
    },
    watch: {
        changeName(next, prev) {
            console.log("변경전 : " + prev + "/ 변경후:" + next);
        },
    },
    methods: {
        changeNaming() {
            this.changeName = "Hwang";
        },
    },
};
</script>
<style scoped></style>
