import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './commons/header/header.component';
import { FooterComponent } from './commons/footer/footer.component';
import {HomeComponent} from './user/home/home.component';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { IntroduceComponent } from './commons/introduce/introduce.component';
import { NewsBookComponent } from './user/news-book/news-book.component';
import { ForeignBookComponent } from './user/foreign-book/foreign-book.component';
import { VietnamBookComponent } from './user/vietnam-book/vietnam-book.component';
import { ChildrenBookComponent } from './user/children-book/children-book.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    IntroduceComponent,
    HomeComponent,
    NewsBookComponent,
    ForeignBookComponent,
    VietnamBookComponent,
    ChildrenBookComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
