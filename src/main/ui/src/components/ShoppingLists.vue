<script setup>
import WelcomeItem from './WelcomeItem.vue'
import DocumentationIcon from './icons/IconDocumentation.vue'
import ToolingIcon from './icons/IconTooling.vue'
import EcosystemIcon from './icons/IconEcosystem.vue'
import CommunityIcon from './icons/IconCommunity.vue'
import SupportIcon from './icons/IconSupport.vue'
import axios from 'axios'
</script>

<template>
    <div v-for="list in limitedLists" v-bind:key="list.id" >

        <WelcomeItem>
          <template #icon>
            <DocumentationIcon />
          </template>

          <a :href="'listview.html?title=' + list.title">{{ list.title }}</a>


          <p class="list-items">
          <template v-for="item in list.list">
                    {{ item }} &nbsp;
          </template>
          </p>
              <button @click="removeList(list.title)">X</button>
        </WelcomeItem>
    </div>

<div id="addItem">
        <input v-model="listName">
        <button @click="addList()">Add list</button>
        </div>
</template>

<script>
export default {
  data() {
    return {
      lists: [],
      listName: ''
    };
  },

  computed: {
    limitedLists() {
        var computedLists = this.lists;

        for (const list of computedLists) {
            var items = list.list
            if (items.length === 0) {
                items = ['empty'];
            } else {
                items = items.slice(0, 3);
            }

            if (list.list.length >= 4) {
                const text = '+' + (list.list.length - 3) + ' more';
                items.push(text);
            }

            list.list = items;
        }

        return computedLists;
    },
  },

  methods: {
        async getData() {
          try {
            const response = await axios.get(
              "http://localhost:8080/groceries"
            );
            this.lists = response.data;
          } catch (error) {
            console.log(error);
          }
        },
        async removeList(list) {
          try {
            const response = await axios.delete(
              "http://localhost:8080/groceries/" + list
            );
          } catch (error) {
            console.log(error);
          }

          this.getData();
        },
        async addList() {
          try {
            const response = await axios.post(
              "http://localhost:8080/groceries/" + this.listName
            );
          } catch (error) {
            console.log(error);
          }

          this.listName = '';

          this.getData();
        },
  },

  created() {
    this.getData();
  },

 };
</script>