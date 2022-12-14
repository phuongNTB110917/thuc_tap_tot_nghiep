import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from './user/home/home.component';
import {IntroduceComponent} from './commons/introduce/introduce.component';
import {NewsBookComponent} from './user/news-book/news-book.component';
import {ForeignBookComponent} from './user/foreign-book/foreign-book.component';
import {VietnamBookComponent} from './user/vietnam-book/vietnam-book.component';
import {ChildrenBookComponent} from './user/children-book/children-book.component';


const routes: Routes = [
  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'introduce',
    component: IntroduceComponent
  },
  {
    path: 'news',
    component: NewsBookComponent
  },
  {
    path: 'foreign',
    component: ForeignBookComponent
  },
  {
    path: 'vietnam',
    component: VietnamBookComponent
  },
  {
    path: 'children',
    component: ChildrenBookComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
