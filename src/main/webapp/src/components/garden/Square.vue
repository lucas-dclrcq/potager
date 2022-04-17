<template>
  <div class="dropdown is-hoverable">
    <div class="dropdown-trigger">
      <div class="garden-square" :class="{'garden-square-cultivated': square.type === 'CULTIVATED'}" aria-haspopup="true" aria-controls="dropdown-menu2">
         ({{ x }}, {{ y }})
      </div>
    </div>
    <div class="dropdown-menu square-menu" id="dropdown-menu2" role="menu">
      <div class="dropdown-content">
        <div class="dropdown-item">
          <p>{{square.id}}</p>
        </div>
        <hr class="dropdown-divider"/>
        <div v-if="square.type === 'EMPTY'" class="dropdown-item">
          <button @click="cultivate()" class="button is-success">Cultivate</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: 'Square',
  props: ['square', 'x', 'y'],
  methods: {
    cultivate() {
      console.log("Cultivating square " + this.square.id)
      axios.post("http://localhost:8080/squares/" + this.square.id + "/cultivate")
          .then(res => this.$props.square.type = 'CULTIVATED')
          .catch(err => console.error("Could not cultivate square"));
    }
  }
}
</script>

<style scoped>
.garden-square {
  height: 100px;
  width: 100px;
  overflow: hidden;
  display: flex;
  align-items: center;
  justify-content: center;
  border: 1px dotted black;
  margin-left: -1px;
  margin-top: -1px;
}

.garden-square-cultivated {
  background-color: rgb(205, 133, 63);
}
</style>