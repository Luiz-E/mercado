import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RemoverListaPopupComponent } from './remover-lista-popup.component';

describe('RemoverListaPopupComponent', () => {
  let component: RemoverListaPopupComponent;
  let fixture: ComponentFixture<RemoverListaPopupComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RemoverListaPopupComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(RemoverListaPopupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
