module.exports = {
  root: true,
  env: {
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
};