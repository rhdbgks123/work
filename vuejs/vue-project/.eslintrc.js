module.exports = {
  root: true,
  env: {
    browser: true,   // 브라우저 전역 객체(window, alert 등) 인식
    node: true,
  },
  extends: [
    "eslint:recommended",
    require.resolve("eslint-plugin-vue/lib/configs/vue3-essential.js")
  ],
  parserOptions: {
    parser: "@babel/eslint-parser",
    ecmaVersion: 2020,
    sourceType: "module",
  },
  plugins: [
    "vue"
  ],
  rules: {
    "vue/no-multiple-template-root": "off",
  },
  globals: {
    alert: "readonly",   // ✅ alert 전역 등록
  },
};