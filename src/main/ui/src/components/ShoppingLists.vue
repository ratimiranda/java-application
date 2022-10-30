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

          <template #heading>{{ list.title }}</template>


          <p class="list-items">
          <template v-for="item in list.list">
                    {{ item }} &nbsp;
          </template>
          </p>
        </WelcomeItem>
    </div>
</template>

<script>
export default {
  data() {
    return {
      lists: [],
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
                items.push('...');
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
        // JSON responses are automatically parsed.
        this.lists = response.data;
        console.log(response)
      } catch (error) {
        console.log(error);
      }
    },
  },

  created() {
    this.getData();
  },

 };
</script>