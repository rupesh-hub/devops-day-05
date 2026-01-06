export const API = {
  MESSAGES: {
    BASE: '/messages',
    BY_ID: (id: string | number) => `/messages/${id}`
  }
} as const;
