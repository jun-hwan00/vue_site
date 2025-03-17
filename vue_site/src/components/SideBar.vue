<script setup>
// props 정의
const props = defineProps({
  isOpen: {
    type: Boolean,
    default: true
  },
  currentPage: {
    type: Number,
    default: 1
  }
});

// 이벤트 정의
const emit = defineEmits(['change-page']);

// 페이지 변경 함수
const handlePageChange = (pageNumber) => {
  emit('change-page', pageNumber);
};

// 사이드바 항목 데이터
const sidebarItems = [
  { id: 1, title: '시작하기', icon: '📝' },
  { id: 2, title: '프로그래밍', icon: '💻' },
  { id: 3, title: '학습 계획', icon: '📅' }
];
</script>

<template>
  <aside class="sidebar" :class="{ 'sidebar-closed': !isOpen }">
    <div class="sidebar-header">
      <h2>페이지 목록</h2>
    </div>
    <ul class="sidebar-menu">
      <li 
        v-for="item in sidebarItems" 
        :key="item.id" 
        :class="{ active: item.id === currentPage }"
        @click="handlePageChange(item.id)"
      >
        <span class="item-icon">{{ item.icon }}</span>
        <span class="item-title">{{ item.title }}</span>
      </li>
    </ul>
  </aside>
</template>

<style scoped>
.sidebar {
  width: 250px;
  background-color: #f7f7f7;
  border-right: 1px solid #e0e0e0;
  transition: width 0.3s;
  overflow-y: auto;
}

.sidebar-closed {
  width: 0;
  overflow: hidden;
}

.sidebar-header {
  padding: 1rem;
  border-bottom: 1px solid #e0e0e0;
}

.sidebar-header h2 {
  margin: 0;
  font-size: 1rem;
  font-weight: 600;
  color: #4b5563;
}

.sidebar-menu {
  list-style: none;
  padding: 0;
  margin: 0;
}

.sidebar-menu li {
  padding: 0.75rem 1rem;
  cursor: pointer;
  display: flex;
  align-items: center;
  transition: background-color 0.2s;
}

.sidebar-menu li:hover {
  background-color: #f0f0f0;
}

.sidebar-menu li.active {
  background-color: #e6f2ff;
  border-left: 3px solid #2563eb;
}

.item-icon {
  margin-right: 0.75rem;
  font-size: 1.1rem;
}

.item-title {
  font-size: 0.95rem;
}
</style>