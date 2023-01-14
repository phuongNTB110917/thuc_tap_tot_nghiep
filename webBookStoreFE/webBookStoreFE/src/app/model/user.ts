import {Cart} from './cart';
import {Role} from './role';

export interface User {
  id?: number;
  username?: string;
  email?: string;
  gender?: string;
  phone?: string;
  birthday?: Date;
  address?: string;
  cart?: Cart;
  provider?: string;
  name?: string;
  active?: string;
  dateCreated?: Date;
  lastUpdated?: Date;
  role?: Role;
}
