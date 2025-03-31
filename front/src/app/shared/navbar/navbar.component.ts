import { Component, HostListener, ViewChild } from '@angular/core';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatSidenav, MatSidenavModule } from '@angular/material/sidenav';
import { MatMenuModule } from '@angular/material/menu';
import { MatListModule } from '@angular/material/list';


@Component({
  selector: 'app-navbar',
  imports: [MatToolbarModule, MatIconModule, MatButtonModule, MatSidenav, MatSidenavModule, MatMenuModule, MatListModule],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.scss'
})

export class NavbarComponent {
  @ViewChild('sidenav') sidenav!: MatSidenav;

  public isLargeScreen = window.innerWidth > 768;

  // isLargeScreen = false; // Default state

  @HostListener('window:resize', ['$event'])
  onResize(event: any) {
    this.isLargeScreen = event.target.innerWidth > 768;
    if (!this.isLargeScreen && this.sidenav) {
      this.sidenav.close(); // Ensure it's closed on small screens
    }
  }
  
  public toggleSidenav(): void {
    if (this.sidenav) {
      this.sidenav.toggle();
    }
  }
}

