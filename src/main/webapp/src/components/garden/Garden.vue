<template>
  <div v-if="error">Oops! Error encountered: {{ error }}</div>
  <h1 v-if="garden" class="subtitle">{{ garden.name }}</h1>
    <div v-if="garden" class="garden-row" v-for="(row,x) in garden.rows">
      <Square v-for="(square, y) in row.squares" :square=square :x=x :y=y />
    </div>
  <div v-if="loading">Loading...</div>
</template>

<script>
import {defineComponent} from 'vue';
import Square from '@/components/garden/Square.vue'

import router from "@/router";
import axios from "axios";

export default defineComponent({
  name: 'Garden',
  components: {Square},
  data() {
    return {
      error: null,
      loading: false,
      garden: null
    }
  },
  methods: {
    fetchGarden() {
      this.loading = true;

      axios.get("http://localhost:8080/gardens")
          .then(res => {
            this.loading = false;
            this.garden = res.data;
          }).catch(err => router.push({path: "/create"}));
    }
  },
  created() {
    this.fetchGarden();
  }
})
</script>

<style scoped>
.garden-row {
  display: flex;
  flex-direction: row;
  flex-wrap: nowrap;
}

</style>