'use client';

import React from 'react';
import Logo from './Logo';
import UserMenu from './UserMenu';
import Search from './Search';

const Navbar = () => {
  return (
    <nav className='fixed w-full bg-white z-10 shadow-sm'>
      <div className='py-4 border-b-[1px] flex flex-row items-center justify-between mx-auto xl:px-20 md:px-10 sm:px-2 px-4'>
        <Logo />
        <Search />
        <UserMenu />
      </div>
    </nav>
  );
};

export default Navbar;
