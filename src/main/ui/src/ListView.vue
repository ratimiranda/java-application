<template>
<h2> {{ title }} </h2>

<template v-for="item in items">
  <button @click="removeItem(item)">X</button>
  <p> {{ item }} </p>
</template>

<input v-model="itemName">
<button @click="addItem()">Add item</button>
</template>

<script>
import axios from 'axios'

export default {
  data() {
    return {
      title: '',
      items: [],
      itemName: ''
    };
  },
  created() {
    let urlParams = new URLSearchParams(window.location.search);
    this.title = urlParams.get('title');
    this.getData();
  },
  methods: {
    async getData() {
      try {
        const response = await axios.get(
          "http://localhost:8080/groceries/" + this.title
        );
        // JSON responses are automatically parsed.
        this.items = response.data.list;
        console.log(response)
      } catch (error) {
        console.log(error);
      }
    },
    async addItem() {

      if (!this.itemName) {
        return;
      }

      const itemNameToAdd = this.itemName;
      this.itemName = '';
      try {
        const response = await axios.post(
          "http://localhost:8080/groceries/" + this.title + "/items/" + itemNameToAdd
        );
        // JSON responses are automatically parsed.
        this.items = response.data.list;
        console.log(response)
      } catch (error) {
        console.log(error);
      }
    },
    async removeItem(item) {
      try {
        const response = await axios.delete(
          "http://localhost:8080/groceries/" + this.title + "/items/" + item
        );
        // JSON responses are automatically parsed.
        this.items = response.data.list;
      } catch (error) {
        console.log(error);
      }
    },
  },
}
</script>
