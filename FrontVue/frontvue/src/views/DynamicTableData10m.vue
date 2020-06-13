<template>
    <div class="dynamic-table">
      <div id="text_area">
        {{data}}
      </div>
    </div>
</template>

<script>
export default {
  data() {
    return {
      data: {},
    };
  },

  beforeMount() {
    this.getText();
  },

  updated() {
    console.warn(`Stop:${Date.now()}`);
  },
  methods: {
    async getText() {
      const res = await fetch('http://localhost:8080/data10m');
      const data = await res.json();
      this.data = data;
    },
  },
  name: 'DynamicTable10m',
};
</script>
