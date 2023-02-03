import {Role} from './role';

export interface RegisterRequest {
  username?: string;
  email?: string;
  password?: string;
  address?: string;
  gender?: string;
  confirmPass: string;
  role?: Role;
}
